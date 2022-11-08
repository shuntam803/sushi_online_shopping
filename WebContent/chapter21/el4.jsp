<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>

<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<!-- chapter21 リストやマップから要素を取り出すサンプル -->

<%
// 配列
int[] array = {0, 1, 2};
request.setAttribute("array", array);

// リスト
List<String> list = new ArrayList<>();
list.add("zero");
list.add("one");
list.add("two");
request.setAttribute("list", list);

// マップ
Map<String, String> map = new HashMap<>();
map.put("zero", "零");
map.put("one", "壱");
map.put("two", "弐");
request.setAttribute("map", map);

%>

<p>${array[0]}</p>
<p>${list[0]}</p>
<!-- マップの場合のみ[]の記法と.の記法が使える -->
<p>${map["one"]}</p>
<p>${map.two}</p>

<%@include file="../footer.html"%>