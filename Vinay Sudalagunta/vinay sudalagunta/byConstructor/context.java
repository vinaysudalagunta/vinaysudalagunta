<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:context="http://www.springframework.org/schema/context"
xsi:schemaLocation="http://www.springframework.org/schema/beans
 http://www.springframework.org/schema/beans/spring-beans.xsd 
 http://www.springframework.org/schema/context
  http://www.springframework.org/schema/context/spring-context-4.3.xsd">
  


<bean id="employee" class="com.zensar.beans.Employee" autowire="constructor">
  <property name="employeeId" value="1"></property>
  <property name="employeeName" value="vijay"></property>

</bean>
 
 <bean id="department" class="com.zensar.beans.Department">
   <property name="departmentCode" value="11"></property>
   <property name="departmentRole" value="devloper"></property>
 
 
 </bean>
</bean>