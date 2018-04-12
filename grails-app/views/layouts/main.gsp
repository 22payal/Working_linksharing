<!DOCTYPE html>
<html lang="en" xmlns:javascript="http://www.w3.org/1999/xhtml">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    %{--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--}%
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <g:layoutHead/>

</head>

<body>
<nav class="navbar navbar">
<div class="container-fluid">
    <div class="col-lg-4">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">LinkSharing</a>
        </div>
    </div>

    <g:if test="${session.user}">
        <div class="col-lg-8">

            <ul class="nav navbar-nav col-lg-12">
                <li class="col-lg-5 ">
                    <g:form controller="topic" action="search" method="post" class="navbar-form navbar-left" >
                        <div class="input-group">
                            <input type="text" class="form-control"name="search" id="search" placeholder="Search...">

                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </g:form>
                </li>


                <li class="col-lg-1 " style="padding: 0px"><a href="#myModal" data-toggle="modal"
                                                              data-target="#myModal"><i class="fa fa-comments"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <g:render template="/topic/createTopic"></g:render>

                <li class="col-lg-1" style="padding: 0px"><a href="#myModal2" data-toggle="modal"
                                                             data-target="#myModal2"><i class="fa fa-envelope"
                                                                                        style="font-size:24px"></i></a>
                </li>

                <g:render template="sendInvite"></g:render>


                <li class="col-lg-1" style="padding: 0px"><a href="#myModal3" data-toggle="modal"
                                                             data-target="#myModal3"><i class="fa fa-link"
                                                                                        style="font-size:24px"></i></a>
                </li>

                <g:render template="/Resource/createResource"></g:render>

                <li class="col-lg-1" style="padding: 0px"><a href="#myModal4" data-toggle="modal"
                                                             data-target="#myModal4"><i class="fa fa-file-text"
                                                                                        style="font-size:24px"></i></a>
                </li>
                <g:render template="/documentResource/shareDocument"></g:render>

                <li class="dropdown  col-lg-3" style="padding: 0px">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user" style="font-size:24px"></i>
                        <b>${session.user.getName()}</b>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><g:link controller="user" action="editProfile">Profile</g:link></li>

                        <g:if test="${session.user.admin==true}">

                        %{--<li><a href="#">Users</a></li>--}%
                            <li><g:link controller="user" action="showUserListToAdmin">Users</g:link></li>
                        <li><a href="#">Post</a></li>
                        <li><a href="#">Topic</a></li>

                       </g:if>

                        <li><g:link controller="login" action="logout">Logout</g:link></li>
                        %{--<li><a href="/login/main.gsp" onclick="javascript:window.history.back()">Logout</a></li>--}%
                    </ul>
                </li>

            </ul>

        </div>

        </div>
    </g:if>
</div>
</nav>

<g:layoutBody/> Copyright © 2017-2018 TO THE NEW. All rights reserved.
</body>
</html>