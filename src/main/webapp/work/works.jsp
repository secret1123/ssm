<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
<head>
    <meta charset="UTF-8" />
    <title>work page</title>
    <script>
        function del() { return confirm('REMOVE?'); }
    </script>
</head>
<body>
<table border="1">
    <tr>
        <th>COUNT</th>
        <th>TITLE</th>
        <th>ARTIST</th>
        <th>PICTURE</th>
        <th>YEAR</th>
        <th>MUSEUM</th>
    </tr>
    <c:forEach var="work" items="${sessionScope.pagination.list}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${work.title}</td>
            <td>${work.artist}</td>
            <td>${work.picture}</td>
            <td>${work.year}</td>
            <td>${work.museum.name}</td>
        </tr>
    </c:forEach>
</table>
<c:import url="${ctx}/commons/page.jsp">
    <c:param name="path" value="work/${sessionScope.pagination.statement}"/>
</c:import>
</body>
</html>