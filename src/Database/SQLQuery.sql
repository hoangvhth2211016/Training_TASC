USE TrainingDatabase
GO

SELECT * FROM production.categories
GO

-- select using join
SELECT p.brand_id, MAX(p.list_price) as most_value_brand
FROM production.products as p
INNER JOIN production.categories as c 
ON p.category_id = c.category_id
WHERE p.model_year > 2016
GROUP BY brand_id
HAVING MAX(p.list_price) > 1000
ORDER BY most_value_brand DESC
GO

SELECT * 
FROM production.products as p
LEFT JOIN sales.order_items as oi on p.product_id = oi.product_id
go

SELECT * 
FROM production.products as p
RIGHT JOIN sales.order_items as oi on p.product_id = oi.product_id
go

SELECT e.staff_id, e.first_name, e.last_name, e.email, (m.first_name +' '+ m.last_name) as manager
FROM sales.staffs as e
JOIN sales.staffs as m on e.manager_id = m.staff_id
GO

-- select using subquery
SELECT p.product_name
from production.products as p
JOIN (
    SELECT TOP 1 product_id
    from sales.order_items
    GROUP BY product_id
    ORDER BY COUNT(*) DESC
) as top_sale
ON p.product_id = top_sale.product_id
GO

-- select using CTE
WITH cte_sales_2016 as (
    SELECT o.order_id, o.order_date FROM sales.orders as o
    WHERE YEAR(o.order_date) = 2016
)
SELECT AVG(oi.list_price*oi.quantity)
FROM sales.order_items as oi
JOIN cte_sales_2016 ON oi.order_id = cte_sales_2016.order_id
GO

-- row_number()
SELECT ROW_NUMBER() OVER (
    ORDER BY p.list_price
) as row_number,
p.product_name,
p.list_price
FROM production.products as p
GO

-- rank()
SELECT RANK() OVER (
    ORDER BY p.list_price
) as row_number,
p.product_name,
p.list_price
FROM production.products as p
GO

-- dense_rank()
SELECT DENSE_RANK() OVER (
    ORDER BY p.list_price
) as row_number,
p.product_name,
p.list_price
FROM production.products as p
GO

-- view
CREATE VIEW staff_view AS
WITH cte_staff AS (
    SELECT st.staff_id, (st.first_name + ' ' + st.last_name) as fullname, st.email, st.phone, st.manager_id 
    FROM sales.staffs as st
)
SELECT cte1.staff_id, cte1.fullname, cte1.email, cte1.phone, cte2.fullname as manager
FROM cte_staff as cte1
JOIN cte_staff as cte2 ON cte1.manager_id = cte2.staff_id
GO

SELECT * from staff_view
GO

-- stored procedurec
CREATE PROC st_income_by_year
    @year INT,
    @income DECIMAL OUT
AS
BEGIN
    SELECT @income = SUM(oi.quantity * (oi.list_price - oi.list_price*oi.discount))
    FROM sales.order_items as oi
    JOIN sales.orders as o ON oi.order_id = o.order_id
    WHERE YEAR(o.order_date) = @year AND o.shipped_date IS NOT NULL
END

DECLARE @result DECIMAL
EXEC st_income_by_year @year = 2016, @income = @result OUTPUT
SELECT @result as sale_in_2016
GO

-- index
CREATE INDEX product_name_idx
ON production.products (product_name)
GO

SELECT 
    i.name AS index_name,
    i.type_desc AS index_type,
    OBJECT_NAME(i.object_id) AS table_name,
    c.name AS column_name
FROM 
    sys.indexes AS i
INNER JOIN 
    sys.index_columns AS ic ON i.object_id = ic.object_id AND i.index_id = ic.index_id
INNER JOIN 
    sys.columns AS c ON ic.object_id = c.object_id AND ic.column_id = c.column_id
WHERE 
    OBJECT_NAME(i.object_id) = 'products'
GO

-- partitions

ALTER DATABASE TrainingDatabase
ADD FILEGROUP SaleYear2016
GO
ALTER DATABASE TrainingDatabase
ADD FILEGROUP SaleYear2017
GO

ALTER DATABASE TrainingDatabase
    ADD FILE 
    (
    NAME = 2016,
    FILENAME = 'location/TrainingDatabase1.ndf',
        SIZE = 3072 KB, 
        MAXSIZE = UNLIMITED, 
        FILEGROWTH = 1024 KB
    ) TO FILEGROUP SaleYear2016
GO

ALTER DATABASE TrainingDatabase
    ADD FILE 
    (
    NAME = 2017,
    FILENAME = 'location/TrainingDatabase2.ndf',
        SIZE = 3072 KB, 
        MAXSIZE = UNLIMITED, 
        FILEGROWTH = 1024 KB
    ) TO FILEGROUP SaleYear2017
GO

CREATE PARTITION FUNCTION PF_Separate_Yearly (DATETIME)
AS RANGE RIGHT FOR VALUES ('20160101', '20170101')
GO

CREATE PARTITION SCHEME p_Yearly
AS PARTITION PF_Separate_Yearly
TO (SaleYear2016, SaleYear2017);