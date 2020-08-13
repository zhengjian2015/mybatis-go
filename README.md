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
