<%@ page import="linksharing.Topic" %>
<div id="myModal4" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share document</h4>
            </div>

            <div class="modal-body row">

                <g:uploadForm controller="documentResource" action="update" method="post">

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="document">document</label>

                        %{--<div class="col-sm-10">--}%
                            %{--<input type="file" class="form-control" id="document" name="document">--}%

                            %{--<input type="text" id="filename" name="filename" placeholder="Add a name to the resource"/>--}%

                        %{--</div>--}%

                        %{--<label class="control-label col-sm-2" for="document">upload</label>--}%
                        <div class="col-sm-10 row">
                            %{--<input type="file" class="form-control" id="document" name="document">--}%

                            <input type="file" id="document" name="document"/>

                        </div>

                    </div>

                    <br>


                    <div class="form-group">
                        <label class="control-label col-sm-2" for="description">description:</label>

                        <div class="col-sm-10">
                            <textarea class="form-control" id="description" rows="5"
                                      placeholder="enter the description of tha resource">

                            </textarea>
                        </div>
                    </div>

                    <div class="dropdown">
                        <label class="control-label col-sm-2" for="topicName">topic:</label>

                        %{--<span class="caret"></span>--}%

                        <g:select name="topicName" from="${Topic.getTopicName(session.user)}"
                                  value="topicName">Topics</g:select>

                    </div>

                    <div class="form-group">
                        <br>

                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">share</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                        </div>
                    </div>
                </g:uploadForm>

            </div>

        </div>

    </div>

</div>