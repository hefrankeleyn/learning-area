<%--
  Created by IntelliJ IDEA.
  User: lifei
  Date: 2019-03-12
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 使用Spring的jsp库--%>


    <h1>Register</h1>
    <%--
    <sf:form> 通过 commandName属性构建针对某个模型对象的上下文。
    设置了commandName属性后，在模型中必须要有一个key为spitter的对象，否则表单不能正常渲染
    也就是，之前的代码为
    public String showRegisterForm() {
        return "registerForm";
    }
    现在要改为：
    public String showRegisterForm02(Model model) {
        model.addAttribute(new Spitter());
        return "/jsplibview/registerForm";
    }

    没有写路径会提交到相同的路径： /spitter/register02
    --%>
    <sf:form method="post" commandName="spitter">
        <sf:errors path="*" element="div" cssClass="errors"/>
        <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>: <sf:input path="firstName" cssErrorClass="error"/><br/>
        <sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>: <sf:input path="lastName" cssErrorClass="error"/><br/>
        <sf:label path="username" cssErrorClass="error">Username</sf:label>:  <sf:input path="username" cssErrorClass="error"/><br/>
        <sf:label path="password" cssErrorClass="error">Password</sf:label>:  <sf:input path="password" cssErrorClass="error"/><br/>
        <input type="submit" value="Register">
    </sf:form>

