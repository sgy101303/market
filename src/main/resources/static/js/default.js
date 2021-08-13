function alertMessage(msg) {
    let toast = $.toast({
        heading: '알림',
        text: msg.toString(),
        icon: 'success',
        hideAfter: 2000,
        position: 'top-right',
        showHideTransition: 'fade',
        allowToastClose: true,
        loaderBg: '#2e8ca7',
        bgColor: '#39afd1'
    });
}

function alertErrorMessage(msg) {
    let toast = $.toast({
        heading: '알림',
        text: msg.toString(),
        icon: 'warning',
        hideAfter: 2000,
        position: 'top-right',
        showHideTransition: 'fade',
        allowToastClose: true,
        loaderBg: '#de3f9d',
        bgColor: '#fa5c7c'
    });
}

function showSuccessModal(title, msg, link) {
    $('#success-alert-modal-title').text(title);
    $('#success-alert-modal-message').text(msg);

    $('#success-alert-modal').modal("show");

    setTimeout(function () {
        location.href = link;
    }, 1000)
}

function pureText(data) {
    let newData;
    let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-+<>@\#$%&\\\=\(\'\"]/gi;

    if (regExp.test(data)) {
        newData = data.replace(regExp, "");
    }else {
        newData = data;
    }
    return newData;

}

var getParameters = function (paramName) {
    var returnValue;

    var url = location.href;

    var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');

    for (var i = 0; i < parameters.length; i++)
    {
        var varName = parameters[i].split('=')[0];
        if (varName.toUpperCase() === paramName.toUpperCase()) {
            returnValue = parameters[i].split('=')[1]; return decodeURIComponent(returnValue);
        }
    }};

function phoneFormatter(num, blur){

    var formatNum = '';

    if(num.length === 11){
        if(blur === true){
            formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-****-$3');
        }else{
            formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
        }
    }else if(num.length === 8){
        formatNum = num.replace(/(\d{4})(\d{4})/, '$1-$2');
    }else{
        if(num.indexOf('02') === 0){
            if(blur === true){
                formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-****-$3');
            }else{
                formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-$2-$3');
            }
        }else{
            if(blur === true){
                formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-***-$3');
            }else{
                formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
            }
        }
    }

    return formatNum;
}

/**
 * 핸드폰, 지역번호 input 정규식
 * @param input (this)
 */
function inputPhoneFormatter(input) {
    if (input.value.length > 13) {
        $(input).val(input.value.substr(0, 13));
    }
    $(input).val(input.value.replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-"));
}

function getFormatDate(date) {
    date = new Date(date);

    let year = date.getFullYear();
    let month = (1 + date.getMonth());
    month = month >= 10 ? month : '0' + month;
    let day = date.getDate();
    day = day >= 10 ? day : '0' + day;

    return year + '-' + month + '-' + day;
}

function getFormatTime(date) {
    date = new Date(date);

    let hours = date.getHours();
    if (hours < 10) { hours = '0' + hours; }
    let minutes = date.getMinutes();
    if (minutes < 10) { minutes = '0' + minutes; }

    return hours + ':' + minutes;
}

function isNull(value) {
    return value === "" || value === null || value === undefined || (typeof value == "object" && !Object.keys(value).length);
}

function formatBusinessLicenseNumber(businessLicenseNumber) {
    if (businessLicenseNumber.length === 10) {
        return businessLicenseNumber.replace(/(\d{3})(\d{2})(\d{5})/, '$1-$2-$3');
    }
    return businessLicenseNumber;

}