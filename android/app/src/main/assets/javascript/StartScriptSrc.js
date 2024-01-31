const defualtColorButtonSvgOff = "rgb(206, 71, 83)"; // off
const defualtColorButtonSvgOn = "rgba(216,235,162,255)"; // on

const defualtBackgroundOneLayerOff = "rgba(43, 32, 74, 0.75)";
const defualtBackgroundOneLayerON = "rgba(150,151,173,255)";

const defualtBackgroundTwoLayerOff = "rgba(73, 46, 82, 0.64)";
const defualtBackgroundTwoLayerOn = "rgba(66, 65, 97, 0.62)";

let StartVpnBool = false;

// toggle
function changheBool(bool = false) {
  StartVpnBool = bool;
  setDefaultValue();
}

// load default values
document.addEventListener("DOMContentLoaded", function () {
  try {
    setDefaultValue();
  } catch (error) {
    alert("error: " + error);
  }
});

function setDefaultValue() {
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
}

// radio and checkbox
// developed by MehrabSp
// let selectedOption;

document.addEventListener("DOMContentLoaded", function () {
  try {
    document
      .querySelectorAll('input[name="defConfigRadios"]')
      .forEach((radio) => {
        radio.addEventListener("change", function () {
          if (this.checked) {
            sendCheckboxValueToKotlin(this.value);
          }
        });
      });
  } catch (error) {
    alert("error! msg: " + error);
  }
});

// send new value to kotlin
function sendCheckboxValueToKotlin(value) {
  try {
    // send value
  } catch (error) {
    alert("error when sending value to kotlin! msg: " + error);
  }
}

// this function add default value to checkboxes from kotlin (mmkv)
// this function call from kotlin
function receiveCheckboxValueFromKotlin(value) {
  // اجرای عملیات مورد نظر با مقدار دریافتی از Kotlin
  try {
    if (value === 1) {
      document.getElementById("exampleRadios1").checked = true;
      document.getElementById("exampleRadios2").checked = false;
    } else if (value === 2) {
      document.getElementById("exampleRadios1").checked = false;
      document.getElementById("exampleRadios2").checked = true;
    } else {
      alert("wrong number");
    }
  } catch (error) {
    alert("error when set value from js");
    showAndroidToast("[receiveCheckboxValueFromKotlin] error!");
  }

  showAndroidToast("value add");
}

// Send event ButtonStart
// Call Kotlin
function receiveButtonValueFromKotlin() {
  try {
    Android.sendEventToKotlin();
  } catch (error) {
    alert("error when set value from js");
  }
}
