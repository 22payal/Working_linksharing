<%@ page import="linksharing.Topic" %>
<div class="col-sm-9">
    <a href="#" class="pull-left">Grails</a>
    <br>
    <div class="row">
        <div class="col-sm-6">
            <h6 class="text-muted">${session.user.userName}</h6>
            <a href="#">Subscribe</a>
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
        <span type="img" class="fa fa-envelope pull-right fa-2x" style="margin-left: 10px;color: #007efc;"></span>

    </div>
</div>



%{--<div class="col-sm-9">--}%
    %{--<g:each in="${Topic.getTrendingTopics()}" var="trendingTopics">--}%
%{--<a href="#" class="pull-left">${trendingTopics.topic.topicName}</a>--}%
%{--<br>--}%
%{--<div class="row">--}%
%{--<div class="col-sm-6">--}%
%{--<h6 class="text-muted">${session.user.userName}</h6>--}%
%{--<a href="#">Unsubscribe</a>--}%
%{--</div>--}%
%{--<div class="col-sm-3">--}%
%{--<h6 class="text-muted pull-left">Subscriptions</h6>--}%
%{--<h6 class="text-primary">50</h6>--}%
%{--</div>--}%
%{--<div class="col-sm-3">--}%
%{--<h6 class="text-muted  pull-right">Post--}%
%{--<br>--}%
%{--<br>--}%
%{--<p class="text-primary">30</p>--}%
%{--</h6>--}%
%{--</div>--}%
%{--<span type="img" class="glyphicon glyphicon-trash pull-right fa-2x"--}%
%{--style="margin-left: 10px;color: #007efc;"></span>--}%
%{--<span type="img" class="fa fa-file pull-right fa-2x"--}%
%{--style="margin-left: 10px;  margin-right: 5px;color: #007efc;"></span>--}%
%{--<span type="img" class="fa fa-envelope pull-right fa-2x" style="margin-left: 10px;color: #007efc;"></span>--}%

%{--<select class="pull-right">--}%
%{--<option>Serious</option>--}%
%{--<option>Casual</option>--}%
%{--<option>Very Serious</option>--}%
%{--</select>--}%
%{--<div>--}%
%{--<select class="pull-right">--}%
%{--<option>Private</option>--}%
%{--<option>Public</option>--}%
%{--</select>--}%
%{--</div>--}%
%{--</div>--}%
    %{--</g:each>--}%
%{--</div>--}%