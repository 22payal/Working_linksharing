<%@ page import="linksharing.Resource" %>
<%@ page import="linksharing.Topic" %>
<%@ page import="linksharing.User" %>

<g:each in="${Resource.getTopPost()}" var="topPosts">
<p>${topPosts.createdBy.getName()}<span style="color: darkgray">@${topPosts.createdBy}</span><span
class="pull-right"
style="margin-right: 0px;color: #007efc;font-size: small">${topPosts.topic.topicName}</span>
</p>

<p><h5> ${topPosts.description}</h5></p>

<i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
<i class="fa fa-google fa-lg" aria-hidden="true"></i>
<i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
<span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"
style="color: #007efc;font-size: small">View Topic</a>
</span>
</g:each>
