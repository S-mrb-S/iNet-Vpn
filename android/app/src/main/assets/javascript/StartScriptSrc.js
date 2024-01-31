const defualtColorButtonSvgOff = "rgb(206, 71, 83)"; // off
const defualtColorButtonSvgOn = "#b2c492"; // on

const defualtBackgroundOneLayerOff = "rgba(43, 32, 74, 0.75)";
const defualtBackgroundOneLayerON = "";

const defualtBackgroundTwoLayerOff = "rgba(73, 46, 82, 0.64)";
const defualtBackgroundTwoLayerOn = "rgba(73, 46, 82, 0.64)";

let StartVpnBool = false;

document.addEventListener("DOMContentLoaded", function () {
  try {
    var vpnImage = document
      .getElementById("vpn-image")
      .querySelector("path").style;
    var vpnOneLayer = document.getElementById("vpn-one-layer").style;
    var vpnTwoLayer = document.getElementById("vpn-two-layer").style;

    vpnImage.fill = StartVpnBool
      ? defualtColorButtonSvgOn
      : defualtColorButtonSvgOff;
    vpnOneLayer.backgroundColor = StartVpnBool
      ? defualtBackgroundOneLayerON
      : defualtBackgroundOneLayerOff;
    vpnTwoLayer.backgroundColor = StartVpnBool
      ? defualtBackgroundTwoLayerOff
      : defualtBackgroundTwoLayerOn;
  } catch (error) {
    alert("error: " + error);
  }
});
