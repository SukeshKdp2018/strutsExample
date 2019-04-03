<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
            <link rel="stylesheet" href="css/bootstrap.min.css">
            <link rel="stylesheet" href="css/style.css">
            <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
            <script type="text/javascript" src="js/bootstrap.min.js"></script>
            <style>
            .table{ display: table }
            .tr{ display: table-row }
            .thead{ display: table-header-group }
            .tbody{ display: table-row-group }
            .tfoot{ display: table-footer-group }
            .col{ display: table-column }
            .colgroup { display: table-column-group }
            .td, .th   { display: table-cell }
            .caption  { display: table-caption }
            </style>
    </head>
    <body>
        <div class="table" width="100%">
            <div class="tr" style="height: 15vh;background-color: #004080;color: white;">
                <div class"td" style="width:10%">
                <img src="image/title.gif"/>
                </div>
                <div class="td">
                   <h1>Ministry Of Health</h1>
                   State of Kuwait
                </div>
            </div>
            <div class="tr" style="height:75vh;">
                <div class="td" style="width: 10%;border: 1px solid;">
                    <tiles:insertAttribute name="menu" />
                </div>
                <div class="td">
                    <tiles:insertAttribute name="body" />
                </div>
            </div>
            <div class="tr" style="height:10vh;">
                
                    <tiles:insertAttribute name="footer" />
                
            </div>
        </div>
    </body>
</html>
