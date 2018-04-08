<div class=" panel panel-default     ">
    <div class="panel-heading  col-lg-12" style="background: #007efc">
        <h3 style="color:white " class="col-lg-8">Top Posts</h3>


        <select name="time" class=" col-lg-3 " style=" margin-top: 25px">
            <option value="today">Today</option>
            <option value="1 week">1 Week</option>
            <option value="1 month">1 Month</option>
            <option value="1 year">1 Year</option>
        </select>

    </div>

    <div class="panel-body  ">
        <div class="col-lg-12">
            <div class="col-lg-3" style="margin-top: 25px">
                <i class="fa fa-user fa-5x" aria-hidden="true"></i>

            </div>

            <div class="col-lg-9">
                <%@ page import="linksharing.ResourceRating;" %>
                <%@ page import="linksharing.Topic" %>
                <%@ page import="linksharing.User" %>

                <g:each in="${ResourceRating.getTopPost()}" var="topPosts">


                    <p>${topPosts.createdBy.userName}<span style="color: darkgray">@${topPosts.createdBy.userName}</span><span
                            class="pull-right"
                            style="margin-right: 0px;color: #007efc;font-size: small">${topPosts.topic.topicName}</span>
                    </p>

                    <p><h5> ${topPosts.description}</h5></p>

                    <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                    <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                    <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                    <span class="pull-right" style="margin-right: 0px;color: #007efc">
                        %{--<a href="#" style="color: #007efc;font-size: small">View Topic</a>--}%
                        %{--<a href="${createLink(uri:'/Resource/topicShow.gsp')}">View Topic</a>--}%
                        <g:link controller="topic" action="show" id="${topPosts.topic.id}"> View Topic</g:link>
                    </span>
                </g:each>

            </div>
        </div>

    </div>
</div>
