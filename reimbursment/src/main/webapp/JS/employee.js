document.getElementById("dt").value=new Date();

function renderTable(reimbursments) {
  for (const reimbursment of reimbursments) {
    
    const tr = document.createElement("tr");
    
    const reimb_Id = document.createElement("td");
    const reimb_amount = document.createElement("td");
    const reimb_submited = document.createElement("td");
    const reimb_resolved = document.createElement("td");
    const reimb_author = document.createElement("td");
    const reimb_resolver = document.createElement("td");
    const reimb_description = document.createElement("td");
    const reimb_status = document.createElement("td");
   
    reimb_Id.innerText = reimbursment.reimb_id;
    reimb_amount.innerText = reimbursment.reimb_amount;
    reimb_submited.innerText=reimbursment.reimb_submitted;
   	reimb_resolved.innerText=reimbursment.reimb_resolved;
  	reimb_author.innerText=reimbursment.reimb_author.fullName;
   	reimb_resolver.innerText=reimbursment.reimb_resolver.fullName;
   	reimb_description.innerText=reimbursment.reimb_description;
   	reimb_status.innerText=reimbursment.status.reimb_status;
    
    tr.append(reimb_Id, reimb_amount, reimb_submited, reimb_resolved, reimb_author, reimb_resolver, reimb_description, reimb_status);

    document.getElementById("ReimbursmentTableBody").append(tr);
  }
}
function renderUser(users) {
  	document.getElementById("ifullName").value=`Welcome to portal  ${users.fullName}`;
  	document.getElementById("iuserName").value=`Username: ${users.username}`;
   document.getElementById("ifirstName").value=`First name: ${users.firstName}`;
   document.getElementById("ilastName").value=`Last name: ${users.lastName}`;
 document.getElementById("iemail").value=`Email address: ${users.email}`;
 }
 
async function asyncFetch(url, expression) {
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}
asyncFetch("http://localhost:8080/Reimbursment/api/data/userinfo.json", renderUser);
asyncFetch("http://localhost:8080/Reimbursment/api/data/reimbursments.json", renderTable);
