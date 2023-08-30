var IMP = window.IMP;
IMP.init('imp00155867')

var today = new Date();
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = hours +  minutes + seconds + milliseconds;

function requestPay() {
    IMP.request_pay({
        pg : 'html5_inicis',
        pay_method : 'card',
        merchant_uid: "IMP"+makeMerchantUid,
        name : '범죄도시',
        amount : 23000,
        buyer_email: "gildong@gmail.com",
        buyer_name: "홍길동",
        buyer_tel: "010-4242-4242",
        display: { card_quote: [3] }
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
}

IMP.request_pay({ /** 요청 객체를 추가해주세요 */ },
    rsp => {
        if (rsp.success) {
            // axios로 HTTP 요청
            axios({
                url: "{서버의 결제 정보를 받는 endpoint}",
                method: "post",
                headers: { "Content-Type": "application/json" },
                data: {
                    imp_uid: rsp.imp_uid,
                    merchant_uid: rsp.merchant_uid
                }
            }).then((data) => {
                // 서버 결제 API 성공시 로직
            })
        } else {
            alert(`결제에 실패하였습니다. 에러 내용: ${rsp.error_msg}`);
        }
    });