let cookieModal = document.querySelector(".cookie-consent-modal")
let cancelCookieBtn = document.querySelector(".btn.cancel")
let acceptCookieBtn = document.querySelector(".btn.accept")
let validateConsent = getCookie("cookieAccepted")

cancelCookieBtn.addEventListener("click", function (){
    cookieModal.classList.remove("active")
    document.cookie = "cookieAccepted=no"
})
acceptCookieBtn.addEventListener("click", function (){
    cookieModal.classList.remove("active")
    document.cookie = "cookieAccepted=yes"
})

function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

setTimeout(function (){
	console.log(validateConsent)
    if (validateConsent === ""){
        cookieModal.classList.add("active")
    }
}, 2000)