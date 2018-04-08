<%@ page contentType="text/html" %>
<html>
<body>
<p>Hello ... You have some unread items in your inbox :
<g:each var="name" in="${list}" status="counter" >
    ${counter}. ${name} <br/>

</g:each>
</p>
<p>Thank you,<br/> linksharing team</p>
</body>
</html>