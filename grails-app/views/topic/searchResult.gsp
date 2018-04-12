<%@ page import="linksharing.Resource; linksharing.Subscription" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title></title>

    <asset:link rel="stylesheet" href="application.css"></asset:link>
    %{--<meta name="layout" content="main">--}%

</head>

<body>

yeah!!

%{--<div class="container">--}%
    %{--<div class="col-lg-6">--}%
        %{--<div class="col-lg-12">--}%
            %{--<g:each in="${topicNames}" var="topic">--}%
            %{--<div class=" panel panel-default     ">--}%

                %{--<div class="panel-heading " style="background: #007efc">--}%
                    %{--<p>--}%
                    %{--<h3 style="color:white">Topic:"${topic.topicName}"</h3>--}%
                   %{--</p>--}%
                %{--</div>--}%

                %{--<div class="panel-body  ">--}%
                    %{--<div class="col-lg-12">--}%
                        %{--<div class="col-lg-3" style="margin-top: 25px">--}%
                            %{--<i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>--}%

                        %{--</div>--}%

                        %{--<div class="col-lg-9">--}%
                            %{--<div class="col-lg-12">--}%
                                %{--<h5><a href="#">${topic.topicName}</a> <span--}%
                                        %{--STYLE="color: #007efc ">(${topic.visibility})</span></h5>--}%
                            %{--</div>--}%

                            %{--<div class="col-lg-12">--}%
                                %{--<div class="col-lg-5">--}%
                                    %{--<p style="color: #007efc">@${topic.createdBy.userName}</p>--}%

                                    %{--<% Subscription subscription = Subscription.findByUserAndTopic(topic.createdBy,topic) %>--}%
                                    %{--<g:if test="${subscription}">--}%

                                        %{--<g:link controller="subscription" action="subscriptionDelete"--}%
                                                %{--id="${topic.id}">Unsubscribe</g:link>--}%
                                    %{--</g:if>--}%

                                    %{--<g:else>--}%
                                        %{--<g:link controller="subscription" action="subscriptionSave"--}%
                                                %{--id="${topic}">Subscribe</g:link>--}%
                                    %{--</g:else>--}%


                                    %{--<ls:toggleSubscribe id="${topic}"> </ls:toggleSubscribe>--}%

                                %{--</div>--}%

                                %{--<div class="col-lg-5">--}%
                                    %{--<p style="color: #007efc">Subscriptions</p>--}%
                                    %{--<p1 style="color: #2e6da4">--}%

                                        %{--${Subscription.countByTopic(topic)}--}%

                                        %{--<ls:subscriptionCount id="${topic}"> </ls:subscriptionCount>--}%
                                    %{--</p1>--}%

                                %{--</div>--}%

                                %{--<div class="col-lg-2">--}%
                                    %{--<p style="color: #007efc">Post</p>--}%
                                    %{--<p1 style="color: #2e6da4">--}%
                                        %{--${Resource.countByTopic(topic)}--}%
                                        %{--<ls:resourceCount id="${topic}"> </ls:resourceCount>--}%
                                    %{--</p1>--}%
                                %{--</div>--}%

                            %{--</div>--}%

                        %{--</div>--}%
                    %{--</div>--}%

                %{--</div>--}%
            %{--</div>--}%

             %{--</g:each>--}%

        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%


</body>
</html>