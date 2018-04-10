<%@ page import="linksharing.Subscription; enumeration.Visibility" %>
<%@ page import="linksharing.Topic" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>

<div class="container">
    <div class="col-lg-6">
        <div class="panel panel-primary col-lg-12">
            <div class="panel-body">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-3 fa fa-user fa-5x">
                        </div>

                        <div class="col-sm-9">

                            <p>${session.user.userName}<br>
                                <small class="text-muted">${session.user.userName}</small>
                            </p>

                            <div class="row">

                                <h6 class="text-muted col-sm-6">Subscriptions
                                    <p class="text-primary">
                                    <ls:userSubscriptionCount/>
                                </p>
                                </h6>

                                <h6 class="text-muted col-sm-6">Topics
                                    <p class="text-primary">
                                    <ls:topicCount/>
                                </p>
                                </h6>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <br><br><br><br>

        <div class="col-lg-12"><br></div>
        <br><br><br><br>


        <div class="panel panel-primary ">
            <div class="panel-heading"><h3 class="panel-title">
                Subscriptions
                <a href="#" class="pull-right">View All</a>
            </h3></div>
            <g:render template="topicCreated"></g:render>
            <hr>

            <g:render template="subscribedTopic"></g:render>

        </div>
        <br>

        <div class="col-lg-12"><br></div>
        <br>


        %{--<div class="panel panel-primary ">--}%
            %{--<div class="panel-heading">--}%
                %{--<h3 class="panel-title">--}%
                    %{--Trending topics--}%
                    %{--<a href="#" class="pull-right">View All</a>--}%
                %{--</h3>--}%
            %{--</div>--}%

                            <g:render template="trendingTopic"></g:render>

            <hr>


        %{--</div>--}%

    </div>

    <br>

    <div class="col-lg-6">
        <div class="row">
            <div class="panel panel-primary ">
                <div class="panel-heading">Inbox</div>

               <g:each in="${resourceList}" var="list">
                <div class="panel-body">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                        </div>

                        <div class="col-lg-9">
                            <p><h6>Created by :  <span style="color: darkgray">${list.createdBy.userName}</span><span
                                class="pull-right"
                                style="margin-right: 0px;color: #007efc;font-size: small">${list.topic.topicName}</span></h6> </p>
                            <p><h5>${list.description}</h5></p>

                            <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"
                                                                                                 style="color: #007efc;font-size: small">Download</a>
                                <a href="#" style="color: #007efc;font-size: small">Mark as Read</a>
                                <g:link controller="resource" action="showPost" id="${list.id}">View Post</g:link></span>

                        </div>
                    </div>

                </div>
               </g:each>
                <hr>

                %{--<div class="panel-body">--}%
                    %{--<div class="col-lg-12">--}%
                        %{--<div class="col-lg-3" style="margin-top: 25px">--}%
                            %{--<i class="fa fa-user fa-5x" aria-hidden="true"></i>--}%

                        %{--</div>--}%

                        %{--<div class="col-lg-9">--}%
                            %{--<p><h6>User's FullName  <span style="color: darkgray">${session.user.getName()}</span><span--}%
                                %{--class="pull-right"--}%
                                %{--style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>--}%
                            %{--<p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>--}%

                            %{--<i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>--}%
                            %{--<i class="fa fa-google fa-lg" aria-hidden="true"></i>--}%
                            %{--<i class="fa fa-twitter fa-lg" aria-hidden="true"></i>--}%
                            %{--<span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"--}%
                                                                                                 %{--style="color: #007efc;font-size: small">Download</a>--}%
                                %{--<a href="#" style="color: #007efc;font-size: small">Mark as Read</a>--}%
                                %{--<a href="#" style="color: #007efc;font-size: small">View Topic</a></span>--}%
                        %{--</div>--}%
                    %{--</div>--}%
                %{--</div>--}%
            </div>
        </div>

    </div>

</div>

</body>
</html>