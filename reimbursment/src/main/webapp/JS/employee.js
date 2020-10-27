


window.addEventListener('load', () => {
    const now = new Date();
    document.getElementById('dt').value = now;
    ajaxGetRequest("http://localhost:8080/Reimbursement/api/status.json",fillStatus,"get")
  });
  
  function ajaxGetRequest(url,expression,method="get"){
        const xhr= new XMLHttpRequest;
        if (xhr.onreadystatechange==4 && xhr.status===200){
            const jsonResponse=JSON.parse(xhr.reponseText);
            expression(jsonResponse);
        }
        xhr.open(method,url)
        xhr.send();
  };

  fillStatus(statuses){
    for (status in statuses)
        console.log(status);
  }

  public void sendAllData(HttpServletResponse res) {
    res.setContentType("text/json");
    List<Monster> monsters = ms.findAll();
    try {
        res.getWriter().println(new ObjectMapper().writeValueAsString(monsters));
    } catch (IOException e) {
    }
}