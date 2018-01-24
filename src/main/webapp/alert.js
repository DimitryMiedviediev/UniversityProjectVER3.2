function runthis() {
    let test = '<%= (String) request.getAttribute("myString") %>';
    alert(test);
}
function runthat() {
    let test = '<%= (JsonNode)request.getSession().getAttribute("UserInfo") %>';
    let event = JSON.parse(test);
    let tot = event[0].email;
    alert(tot);
}