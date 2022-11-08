<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html"%>
<%@ include file="../chapter25/menu.jsp"%>

<!-- ログイン名とパスワードを入力するJSPファイル -->
<form action="Login.action" method="post">

  <table>
    <tr>
      <td>ログイン名</td>
      <td>:</td>
      <td><input type="text" name="login" required></td>
    </tr>
    <tr>
      <td>パスワード</td>
      <td>:</td>
      <td><input type="password" name="password" required></td>
      <td><input type="submit" value="ログイン"></td>
    </tr>

  </table>
  <p>※テスト用ログイン名 : ayukawa</p>
  <p>※テスト用パスワード : SweetfishRiver1</p>

</form>

<%@include file="../footer.html"%>