-- 按时间格式进行搜索
SELECT * FROM t WHERE date_format(end_time, '%Y-%m-%d %H:%i:%S') like '%00:00:00%';
