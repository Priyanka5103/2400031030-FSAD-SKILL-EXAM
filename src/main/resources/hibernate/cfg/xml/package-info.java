<!DOCTYPE hibernate-configuration PUBLIC
 "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
 "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
<session-factory>

<property name="hibernate.connection.driver_class">
com.mysql.cj.jdbc.Driver
</property>

<property name="hibernate.connection.url">
jdbc:mysql://localhost:3306/fsadexam
</property>

<property name="hibernate.connection.root">root</property>

<property name="hibernate.connection.welcome">root</property>

<property name="hibernate.dialect">
org.hibernate.dialect.MySQL8Dialect
</property>

<property name="hibernate.hbm2ddl.auto">update</property>

<property name="hibernate.show_sql">true</property>

<mapping class="com.klef.fsad.exam.Hospital"/>

</session-factory>
</hibernate-configuration>