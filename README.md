# redis的安装

**redis是单线程的**	

redis是基于内存的，cpu不是它的性能瓶颈，redis的瓶颈是根据机器的内存和网络带宽，既然可以用单线程就用单线程

6.0 以后貌似已经用多线程了



cd redis-6.0.8

make

cd src

make install 

redis的默认安装是 /usr/local/bin

再bin目录下 mkdir kconfig

cp /home/jian/redis-6.0.6/redirs.conf  kconfig/

redis-server kconfig/redis.conf

redis-cli -p 6379



**常用命令**

```
set age 11  #key为age value为11

keys *

EXIST age 

move age 1  (1表示当前数据库，移除)

EXPIRE age 10  #10s中后过期

ttl age  #查看剩余时间

type age #查看age的类型

select 0 选择数据库0  默认有16个数据库 默认是0
```





# 常用类型

## String

```
set key1 v1

get key 1

APPEND key1 "hello"  #追加字段，如果key不存在，就相当于setkey

STRLEN key1  #长度

set views 0 

get views

incr views

incr views #+1

decr views #-1

INCRBY views 10 #加10

decrby views 10 #-10

getrange key1 0 3 #截取字符串[0,3]

setrange key1 1  xx #替换1位置的字符串


###################################################################
#setex(set with expire)  #设置过期时间
#setnx(set if not exist) #不存在在设置 在分布式锁中会常常使用

setex key3 30 "hello" #设置key3 30s

setnx mykey "redis"

setnx mykey "mongdb"

get mykey

mset k1 v1 k2 v2 k3 v3 #批量设置
mget k1 k2 k3	

msetnx k1 v1 k4 v4 #msetnx是个原子性的操作，要么一起成功，要么一起失败
(integer) 0

#对象
set user:1 {name:zhengj,age:28}
#这里的key是一个巧妙的设计：user:{id}:{field} 如此设计在redis里是完全ok的

也可以yongmset
mset user:1:name zhangsan user:1:age 29
mget user:1:name user:1:age


getset #先get后set
getset db redis 如果不存在的值则返回nil
get db
getset db mongdb
get db


```



## list

可以把list玩成 栈 队列 阻塞队列

```
lpush list one  

lpush list two

lpush list three

lrange list 0 -1  #从上往下 0 1 2

rpush list four #往另一边往里塞

lpop  #删除左边最后一个元素

rpop #删除右边最后一个元素

lindex #通过下标获取元素

lindex list 1

llen list #获取长度

lrem list 1 obe  #移除指定个数指定值 可以用来表示取消关注

ltrim list 1 2 #通过下标截取指定长度，这个list已经改变，截断了只剩下截取的元素

rpoplpush 移除列表的最后一个元素并添加到新的数组中

exists list #判断list是否存在

lset list 0 abc  #如果存在就更新

linsert list brfore abc  rfg #在abc之前插入rfg


```

## set

```
字符串加不加引号 或者单引号都没影响
sadd myset "hello"

sadd myset "zhengjian"

smembers myset #查看set里的所有值

sismembers myset hello #查看myset是否有元素 hello

scard myset #查看结果数量

srem myset hello #移除指定元素 hello

sranmembers myset #随机找到一个元素

spop myset #随机删除一个元素

smove myset myset2 "hello" #把指定的一个值移动到另一个set集合中


127.0.0.1:6379> SADD key1 a
(integer) 1
127.0.0.1:6379> SADD key1 b
(integer) 1
127.0.0.1:6379> sadd key1 c
(integer) 1
127.0.0.1:6379> sadd key2 c
(integer) 1
127.0.0.1:6379> sadd key2 d
(integer) 1
127.0.0.1:6379> SADD key2 f
(integer) 1
127.0.0.1:6379> SDIFF key1 key2 #差集
1) "b"
2) "a"
127.0.0.1:6379> SINTER key1 key2 #交集
1) "c"
127.0.0.1:6379> SUNION key1 key2 #并集
1) "c"
2) "a"
3) "d"
4) "b"
5) "f"
127.0.0.1:6379> 

```

## hash

map集合

```
127.0.0.1:6379> hset myhash field1 zhengjian  #设置
(integer) 1
127.0.0.1:6379> hset myhash field2 wln
(integer) 1
127.0.0.1:6379> hget myhash field1 #获取
"zhengjian"
127.0.0.1:6379> hmset myhash field3 ilove filed4 you #多个
OK
127.0.0.1:6379> hmget myhash field1 field3 #获取多个值
1) "zhengjian"
2) "ilove"
127.0.0.1:6379> hgetall myhash
1) "field1"

hlen myhash #判断长度
hkeys myhash #获取key
hvalues myhash #
hincrby myhash field1 #增加
hsetnx myhash fileld1 eee #如果不存在则设置 如果存在则不能设置 可以用来分布式锁 
```



## zset

在set的基础上增加了一个值 set k1 v1 zset k1 score v1

```
zadd myzset 1 one  #添加一个

zadd myzset 2 two 3 three #添加多个

zrange myzset 0 -1  #获取全部

127.0.0.1:6379> ZADD ages 30 wanglinna
(integer) 1
127.0.0.1:6379> zadd ages 28 zhengjian
(integer) 1
127.0.0.1:6379> zadd ages 27 zhangss
(integer) 1

ZRANGEBYSCORE ages -inf +inf #从小大大排列 负无穷到正无穷



```

# 三种特殊的数据类型

## geospatial 地址位置

```
geoadd china:city 121.47 31.23 shanghai

geoadd china:city 120.16 30.24 hangzhou

127.0.0.1:6379> GEODIST china:city hangzhou shanghai
"166761.2770"
127.0.0.1:6379> GEODIST china:city hangzhou shanghai km
"166.7613"

georadius china:city 110 30 500 km

georadius china:city 110 30 500 km withdist #显示到中心位置的距离


```

## Hyperloglog	

什么是基数 ？两个数组中不重复的元素

网页的uv(不同的人访问数)

优点占用内存小



## Bitmaps

位存储 只有 0 1 

可以用来签到

setbit



# 事务

## 基础操作

Redis事务的本质:一组命令的集合！ 一个事务中的所有命令都会被序列化，在事务执行的过程中，会按照顺序执行

一次性，顺序性，排他性，执行一些列的命令

-----队列 set set set 队列--------



Redis单条命令保存原子性，但是事务不保证原子性

redis的事务

开启事务 （multi)

命令入队

执行事务  (exec)

正常执行事务	



```
127.0.0.1:6379> multi
OK
127.0.0.1:6379> set k1 a1
QUEUED
127.0.0.1:6379> set k2 a2
QUEUED
127.0.0.1:6379> get k1
QUEUED
127.0.0.1:6379> set k3 a3
QUEUED
127.0.0.1:6379> exec
1) OK
2) OK
3) "a1"
4) OK
127.0.0.1:6379> 
```

放弃事务 discard

## 两种异常情况：

1.编译型异常  事务中所有命令都不执行

```
127.0.0.1:6379> multi
OK
127.0.0.1:6379> set k1 v1
QUEUED
127.0.0.1:6379> set k2 v2
QUEUED
127.0.0.1:6379> getset k2
(error) ERR wrong number of arguments for 'getset' command
127.0.0.1:6379> get k1
QUEUED
127.0.0.1:6379> exec
(error) EXECABORT Transaction discarded because of previous errors.
127.0.0.1:6379> get k1
(nil)
127.0.0.1:6379> 
```

2.运行时异常，出错的命令不执行，其他照常执行

```
127.0.0.1:6379> multi
OK
127.0.0.1:6379> set k1 v1
QUEUED
127.0.0.1:6379> set k2 v2
QUEUED
127.0.0.1:6379> incr k1
QUEUED
127.0.0.1:6379> get k2
QUEUED
127.0.0.1:6379> exec
1) OK
2) OK
3) (error) ERR value is not an integer or out of range
4) "v2"
```

## 乐观锁

悲观锁：很悲观，认为无论做什么都会出错，每一次都要加锁

乐观锁：很乐观，认为大概率不会出错，cas compare and swap,mysql加个version来比较

redis里的watch就是乐观锁

```
127.0.0.1:6379> watch money
OK
127.0.0.1:6379> set money 100
OK
127.0.0.1:6379> set out 0
OK
127.0.0.1:6379> multi
OK
127.0.0.1:6379> DECRBY money 2
QUEUED
127.0.0.1:6379> INCRBY out 2
QUEUED
127.0.0.1:6379> exec
(nil)
127.0.0.1:6379> 
#此时用另一个线程，再起一个rediscli,改变money的值，就是nil
再操作一遍就成功了， unwatch再执行money操作

127.0.0.1:6379> UNWATCH
OK
127.0.0.1:6379> WATCH money
OK
127.0.0.1:6379> MULTI
OK
127.0.0.1:6379> DECRBY money 5
QUEUED
127.0.0.1:6379> INCRBY out 5
QUEUED
127.0.0.1:6379> exec
1) (integer) 990
2) (integer) 10
127.0.0.1:6379> 


```

