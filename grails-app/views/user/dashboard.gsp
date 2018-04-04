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

                            <p>${session.user.getName()}<br>
                                <small class="text-muted">${session.user.userName}</small>
                            </p>

                            <div class="row">

                                <h6 class="text-muted col-sm-6">Subscriptions
                                    <p class="text-primary">${Subscription.countByUser(session.user)}</p>
                                </h6>

                                <h6 class="text-muted col-sm-6">Topics
                                    <p class="text-primary">${Topic.countByCreatedBy(session.user)}</p>
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
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-3 fa fa-user fa-5x">
                            </div>
                            <div class="col-sm-9">
                                <a href="#" class="pull-left">Grails</a>
                                <br>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h6 class="text-muted">${session.user.userName}</h6>
                                        <a href="#">Unsubscribe</a>
                                    </div>
                                    <div class="col-sm-3">
                                        <h6 class="text-muted pull-left">Subscriptions</h6>
                                        <h6 class="text-primary">50</h6>
                                    </div>
                                    <div class="col-sm-3">
                                        <h6 class="text-muted  pull-right">Post
                                            <br>
                                            <br>
                                            <p class="text-primary">30</p>
                                        </h6>
                                    </div>
                                    <span type="img" class="glyphicon glyphicon-trash pull-right fa-2x"
                                          style="margin-left: 10px;color: #007efc;"></span>
                                    <span type="img" class="fa fa-file pull-right fa-2x"
                                          style="margin-left: 10px;  margin-right: 5px;color: #007efc;"></span>
                                    <span type="img" class="fa fa-envelope pull-right fa-2x" style="margin-left: 10px;color: #007efc;"></span>

                                    <select class="pull-right">
                                        <option>Serious</option>
                                        <option>Casual</option>
                                        <option>Very Serious</option>
                                    </select>
                                    <div>
                                        <select class="pull-right">
                                            <option>Private</option>
                                            <option>Public</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr>

           <g:render template="subscribedTopic"></g:render>


        </div>
        <br>
        <div class="col-lg-12"><br></div>
        <br>


        <div class="panel panel-primary ">
            <div class="panel-heading">
                <h3 class="panel-title">
                    Trending topics
                    <a href="#" class="pull-right">View All</a>
                </h3>
            </div>
            <div class="panel-body ">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-5 fa fa-user fa-5x">
                            </div>

                         <g:render template="trendingTopic"></g:render>


                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-3 fa fa-user fa-5x">
                            </div>

                        </div>
                    </div>

                </div>

            </div>
        </div>

    </div>
    <div class="col-lg-6">
        <div class="panel panel-primary " >
            <div class="panel-heading">Inbox</div>
            <div class="panel-body">
                <div class="col-lg-12">
                    <div class="col-lg-3" style="margin-top: 25px">
                        <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                    </div>
                    <div class="col-lg-9">
                        <p><h6>User's FullName  <span style="color: darkgray">${session.user.userName}</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                        <p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>

                        <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                        <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">Download</a>
                            <a href="#" style="color: #007efc;font-size: small"> Mark as Read</a>
                            <a href="#" style="color: #007efc;font-size: small"> View Topic</a></span>

                    </div>
                </div>

            </div>
            <hr>
            <div class="panel-body">
                <div class="col-lg-12">
                    <div class="col-lg-3" style="margin-top: 25px">
                        <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                    </div>
                    <div class="col-lg-9">
                        <p><h6>User's FullName  <span style="color: darkgray">${session.user.getName()}</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                        <p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>

                        <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                        <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                        <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">Download</a>
                            <a href="#" style="color: #007efc;font-size: small"> Mark as Read</a>
                            <a href="#" style="color: #007efc;font-size: small"> View Topic</a></span>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>