import  unittest
from api2018.Sendhttp import SendHttp
from api2018.DataProvider import readExcel
from api2018 import Common

class qgLoginTest(unittest.TestCase):

    def setUp(self):
        self.url="/common/fgadmin/login"

    # def test_login_by_para(self):
    #     sheet=readExcel(r"D:\demo\userdata.xlsx", 0)
    #     for i in range(sheet.nrows):
    #         user = {"phoneArea": "86",
    #                 "phoneNumber": sheet.cell_value(i, 0),
    #                 "password": "netease123"}
    #         result = SendHttp().run_http(self.url, "POST", user)
    #         print(result)
    #         self.assertEqual(result['code'], 200)


    def test_login_success(self):
        user={"phoneArea":"86",
              "phoneNumber":"20000000000",
              "password":"netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        print(result)
        self.assertEqual(result['code'],200)
        self.assertEqual(result['message'], 'success')


    def test_login_fail_1(self):

        user={"phoneArea":"86",
              "phoneNumber":"20000000000",
              "password":"netease1231"}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)
    def test_login_fail_2(self):

        user={"phoneArea":86,
              "phoneNumber":"20000000000",
              "password":"netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)
    def test_login_fail_3(self):

        user={"phoneArea":"86",
              "phoneNumber":20000000000,
              "password":"netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)

    def test_login_fail_4(self):

        user={"phoneArea":"86",
              "phoneNumber":"20000000000",
              "password":123}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)

    def test_login_fail_5(self):

        user={"phoneNumber":"20000000000",
              "password":"netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)

    def test_login_fail_6(self):

        user={"phoneArea":"86",
              "phoneNumber":"20000000000",}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)

    def test_login_fail_7(self):

        user={"phoneArea":"86",
              "phoneNumber":"200000000000000",
              "password":"netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)

    def test_login_fail_8(self):

        user={"phoneArea":"86",
              "phoneNumber":"10086",
              "password":"netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        self.assertEqual(result['code'], 400)