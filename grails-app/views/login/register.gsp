<%@ page import="linksharing.Resource" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
    <meta name="layout" content="main">

</head>

<body>

<div class=" container">
    <div class="col-lg-6">
        <div class="col-lg-12" style="margin-top: 25px">

            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #007efc">
                    <p>

                    <h3 style="color:white">Recent Shares</h3></p>
                </div>

                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <g:each in="${Resource.getRecentShares()}" var="recentShares">
                            <div class="col-lg-3" style="margin-top: 25px">
                                <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                            </div>

                            <div class="col-lg-9">
                                <p>${recentShares.createdBy.name}  <span
                                        style="color: darkgray">@${recentShares.createdBy.username}</span><span
                                        class="pull-right"
                                        style="margin-right: 0px;color: #007efc;font-size: small">${recentShares.topic.name}</span>
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
                    </div>

                </div>
            </div>

        </div>

        <div class="col-lg-12" style="margin-top: 25px">

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
                            %{--<g:each in="${Resource.getTopPost()}" var="topPosts">--}%
                                %{--<p>${topPosts.createdBy}<span style="color: darkgray">@${topPosts.createdBy}</span><span--}%
                                        %{--class="pull-right"--}%
                                        %{--style="margin-right: 0px;color: #007efc;font-size: small">${topPosts.topicName}</span>--}%
                                %{--</p>--}%

                                %{--<p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>--}%


                                %{--<i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>--}%
                                %{--<i class="fa fa-google fa-lg" aria-hidden="true"></i>--}%
                                %{--<i class="fa fa-twitter fa-lg" aria-hidden="true"></i>--}%
                                %{--<span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"--}%
                                                                                                     %{--style="color: #007efc;font-size: small">View Topic</a>--}%
                                %{--</span>--}%
                            %{--</g:each>--}%

                        </div>
                    </div>

                </div>
            </div>

        </div>

    </div>

    <div class="col-lg-6">

        <div class="panel-body ">
            <g:form controller="login" action="loginHandler" method="post">
                <div class="form-group col-lg-10">
                    <label>Username</label>
                    <input class="form-control" type="text" name="loginusername" placeholder="enter your username">
                </div><div class="col-lg-2"></div>
                <div class="form-group col-lg-10">
                    <label>Password</label>
                    <input class="form-control" type="password" name="loginpassword" placeholder="enter your password">

                </div>
                <div class="col-lg-12"></div>
                <div class="form-group col-lg-5" >
                    <p><a href="#">Forgot Password</a></p>
                </div>
                <div  class="form-group col-lg-10">
                    <input type="submit" class="form-control btn-primary" style="background:#007efc">
                </div>


            </g:form>

        </div>




        <div class="panel-body ">
            <g:form controller="login" action="register" method="post">
                <div class="form-group col-lg-10">
                    <label>First Name</label>
                    <input class="form-control" type="text" name="firstName" placeholder="enter your first name">
                </div><div class="col-lg-2"></div>
                <div class="form-group col-lg-10">
                    <label>Last name </label>
                    <input class="form-control" type="text" name="lastName" placeholder="enter your last name">

                </div>
                <div class="form-group col-lg-10">
                    <label>Email </label>
                    <input class="form-control" type="email" name="email" placeholder="enter your email">

                </div>
                <div class="form-group col-lg-10">
                    <label>Username </label>
                    <input class="form-control" type="text" name="userName" >

                </div>

                <div class="form-group col-lg-10">
                    <label>Password </label>
                    <input class="form-control" type="password" name="password" placeholder="enter password">

                </div>
                <div class="form-group col-lg-10">
                    <label>Confirm Password </label>
                    <input class="form-control" type="password" name="confirmPassword" placeholder="confirm your  password">

                </div>

                <div  class="form-group col-lg-10">
                    <input type="submit" class="form-control btn-primary" style="background:#007efc">
                </div>


            </g:form>
        </div>

    </div>

</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>