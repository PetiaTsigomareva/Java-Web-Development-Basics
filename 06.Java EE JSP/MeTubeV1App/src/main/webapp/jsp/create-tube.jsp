<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="container">
    <main>
        <div class="jumbotron">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h1>Create Tube!</h1>
                </div>
            </div>
            <hr/>
            <form action="/tubes/create" method="post">
                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="nameInput">Title:</label>
                        </div>
                        <div class="row d-flex justify-content-center">
                            <input name="name" type="text" id="nameInput">
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="descriptionInput">Description:</label>
                        </div>

                        <div class="row d-flex justify-content-center">
                            <textarea name="description" id="descriptionInput" cols="22" rows="4"></textarea>
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="YouTubeLinkInput">YouTubeLink:</label>
                        </div>
                        <div class="row d-flex justify-content-center">
                            <input name="YouTubeLink" type="text" id="YouTubeLinkInput">
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col col-md-12">
                        <div class="row d-flex justify-content-center">
                            <label for="UploaderInput">Uploader:</label>
                        </div>
                        <div class="row d-flex justify-content-center">
                            <input name="uploader" type="text" id="UploaderInput">
                        </div>
                    </div>
                </div>
                <hr/>
                <div class="row mt-4">
                    <div class="col col-md-12 d-flex justify-content-center">
                        <button type="submit" class="btn btn-primary">Create Tube</button>
                    </div>
                </div>

            </form>
            <hr/>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <a href="/">Back to Home page</a>
                </div>
            </div>
        </div>
    </main>
    <footer><c:import url="templates/footer.jsp"/></footer>
</div>
</body>

</html>
