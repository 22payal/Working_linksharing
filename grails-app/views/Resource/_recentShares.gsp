<%@ page import="linksharing.Resource" %>

<g:each in="${Resource.getRecentShares()}" var="recentShares">
    <div class="col-lg-3" style="margin-top: 25px">
        <i class="fa fa-user fa-5x" aria-hidden="true"></i>

    </div>

    <div class="col-lg-9">
        <p>${recentShares.createdBy.name}  <span
                style="color: darkgray">@${recentShares.createdBy.userName}</span><span
                class="pull-right"
                style="margin-right: 0px;color: #007efc;font-size: small">${recentShares.topic.topicName}</span>
        </p>

        <p>${recentShares.description}</p>

        <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
        <i class="fa fa-google fa-lg" aria-hidden="true"></i>
        <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
        <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"
                                                                             style="color: #007efc;font-size: small">View Topic</a>
        </span>
    </div>
    <hr>
</g:each>
