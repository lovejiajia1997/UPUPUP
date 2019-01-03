import  unittest
from api2018.Sendhttp import SendHttp
from api2018 import Common
#刘江 查询地址

class addressList(unittest.TestCase):

    def setUp(self):
        self.url= "/fgadmin/address/list"

    def test_address_by_Login_success(self):
        user = {"phoneArea": "86",
                "phoneNumber": "20000000000",
                "password": "netease123"}
        result=SendHttp().sent_get_bycookies(self.url,Common.getcookies(user))
        print(result)
        self.assertEqual(result['code'],200)
    def test_address_by_Login_fail(self):
        user = {"phoneArea": "86",
                "phoneNumber": "20000000078",
                "password": "netease123"}
        result=SendHttp().sent_get_bycookies(self.url,Common.getcookies(user))
        print(result)
        self.assertEqual(result['code'],201)
        self.assertEqual(result['message'], '收货地址为空')
    if __name__ == '__main__':
            unittest.main()
