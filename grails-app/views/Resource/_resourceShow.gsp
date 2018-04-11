<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
    %{--<meta name="layout" content="main">--}%
    <asset:link rel="stylesheet" href="application.css"></asset:link>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">


</head>

<body>

<div class="container">
    <div class="col-lg-7">

        <div class="col-lg-12">
            <div class="col-lg-12">
                <div class=" panel panel-default     ">

                    <div class="panel-body  ">
                        <div class="col-lg-12">
                            <div class="col-lg-3" style="margin-top: 25px">
                                <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                            </div>

                            <div class="col-lg-9">
                                <div class="col-sm-12">
                                    <br>

                                    <div class="col-lg-5">
                                        <span>${resource.ownerName} <small
                                                class="text-muted">@${resource.ownerUsername}</small>
                                        </span>

                                    </div>

                                    <div class="col-lg-7" style="text-align: right">
                                        <p>${resource.topicName}</p><br>
                                    </div>

                                    <div class="col-lg-12"><br><br></div>


                                    <div class="col-lg-12">
                                        <div class="col-lg-12">
                                            <p>${resource.resourceDescription}</p>
                                        </div>
                                    </div>

                                    <div class="col-lg-12"><br></div>

                                </div>

                            </div>

                            <div class="col-lg-12" style="text-align: ">
                                <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                                <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                                <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>
                                <span class="pull-right" style="margin-right: 0px;color: #007efc">
                                    <g:if test="${session.user}">
                                        <a href="#" style="color: #007efc;font-size: 90%">Download</a>
                                    </g:if>
                                </span>
                            </div>

                        </div>

                    </div>
                </div>

            </div>

        </div>

    </div>

    <div class="col-lg-5">
        <g:render template="/user/trendingTopic">

        </g:render>
    </div>
</div>

</body>
</html>