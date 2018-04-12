<%@ page import="linksharing.Resource" contentType="text/html;charset=UTF-8" %>
<%@ page import="linksharing.Subscription" contentType="text/html;charset=UTF-8" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="col-lg-6">
        <div class="col-lg-12">
            <g:each in="${topicNames}" var="topic">
                <div class="panel panel-default">

                    <div class="panel-heading " style="background: #007efc">
                        <h3 style="color:white">Topic:"${topic.topicName}"</h3>
                    </div>
                    <div class="panel-body  ">
                        <div class="col-lg-12">
                            <div class="col-lg-3" style="margin-top: 25px">
                                <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                            </div>

                            <div class="col-lg-9">
                                <div class="col-lg-12">
                                    <h5>

                                        <a href="#">${topic.topicName}</a>
                                        %{--<a href="#">${topic.topicName}</a>--}%

                                        <span STYLE="color: #007efc ">(${topic.visibility})</span></h5>
                                </div>
                                <div class="col-lg-12">
                                    <div class="col-lg-5">
                                        <p style="color: #007efc">@${topic.createdBy.userName}</p>

                                    </div>
                                    <div class="col-lg-5">
                                        <p style="color: #007efc">Subscriptions</p>
                                        <p style="color: #2e6da4">

                                            <ls:subscriptionCount id="${topic}"> </ls:subscriptionCount>
                                        </p>

                                    </div>

                                    <div class="col-lg-2">
                                        <p style="color: #007efc">Post</p>
                                        <p style="color: #2e6da4">

                                            <ls:resourceCount id="${topic}"> </ls:resourceCount>
                                        </p>
                                    </div>


                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </g:each>

        </div>
    </div>
</div>
</body>
</html>