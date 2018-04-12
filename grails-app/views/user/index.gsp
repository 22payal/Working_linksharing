%{--<g:if test="${session.user.userName}">--}%
    <div class="col-lg-8">

        <ul class="nav navbar-nav col-lg-12">
            <li class="col-lg-5 ">
                <form class="navbar-form navbar-left" action="/action_page.php">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search...">

                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
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
                <a class="dropdown-toggle" data-toggle="dropdown" href="/area/"><i class="fa fa-user"
                                                                              style="font-size:24px"></i>
                    <b>${session.user.userName}</b>
                    <span class="caret"></span>

                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>

<g:if test="${session.user.admin}">

                    <li><a href="#">Users</a></li>
                    <li><a href="#">Post</a></li>
                    <li><a href="#">Topic</a></li>

</g:if>

                    <li><g:link controller="login" action="logout">Logout</g:link></li>
                </ul>
            </li>

        </ul>

    </div>

    </div>
%{--</g:if>--}%