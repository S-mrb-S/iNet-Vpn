/* Set the width of the side navigation to 250px and the left margin of the page content to 250px and add a black background color to body */
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    // document.getElementById("main").style.marginLeft = "250px";
    // document.body.style.backgroundColor
    document.getElementById("back-color").style.backgroundColor =
      "rgba(0,0,0,0.4)";
  }

  /* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
  function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    // document.getElementById("back-color").style.marginLeft = "0";
    document.getElementById("back-color").style.backgroundColor = "";
  }

  function toggleVpnOn() {}
  document
    .getElementById("vpn-select")
    .addEventListener("click", function () {
      var vpnImage = document
        .getElementById("vpn-image")
        .querySelector("path").style;

      vpnImage.fill = "blue";
      // vpnImage.style.opacity = "0"; // تصویر را ناپدید کنید

      // // vpnImage.src = "./style_html/bg_connected.png";
      // vpnImage.hide("slide", { direction: "left" }, 1000);
      // vpnImage
      //   .eq(thumbs.index(this))
      //   .show("slide", { direction: "left" }, 1000);
      // vpnImage.style.opacity = "1"; // تصویر را نمایان کنید
    });

  // close modal
  // Get the modal
  var modal = document.getElementById("myModal");

  // Get the button that opens the modal
  var btn = document.getElementById("myBtn");

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks the button, open the modal
  btn.onclick = function () {
    modal.style.display = "flex";
  };

  // When the user clicks on <span> (x), close the modal
  span.onclick = function () {
    modal.style.display = "none";
  };

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  };