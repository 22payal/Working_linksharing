<%@ page contentType="text/html" %>
<html>
<body>
<p>Hello ... You can now subscribe to this topic :
    %{--<a href="${link}">${link}</a>--}%
<g:link controller="topic" action="join" id="${link}" params="${email}"  absolute="true"> Click this link .. </g:link>

</p>
<p>Thank you,<br/> linksharing team</p>
</body>
</html>