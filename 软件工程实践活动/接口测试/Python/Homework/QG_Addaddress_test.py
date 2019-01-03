import unittest
from api2018.Sendhttp import SendHttp
from api2018 import Common
from Homework.QG_Add_address import Action

#沈梦琪 添加收货地址接口

class AddAddress(unittest.TestCase):
    def test_add_address_success(self):
        res = Action().default_para()
        self.assertEqual(res['code'], 200)

    def test_add_address_failed_name_type_01(self):
        res = Action().type_para("receiverName", 123)
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "receiverName参数类型不正确")

    def test_add_address_failed_name_type_02(self):
        res = Action().type_para("receiverName", "")
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "请求参数不正确")

    def test_add_address_failed_phone_type_01(self):
        res = Action().type_para("cellPhone",12345678901)
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "cellPhone参数类型不正确")

    def test_add_address_failed_phone_type_02(self):
        res = Action().type_para("cellPhone", None)
        self.assertEqual(res['code'], 400)
        # self.assertEqual(res['message'], "请求参数不正确")
        self.assertEqual(res['message'], "may not be null")

    def test_add_address_failed_detail_type(self):
        res = Action().type_para("addressDetail", 123)
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "addressDetail参数类型不正确")

    def test_add_address_failed_province_type(self):
        res = Action().type_para("province", 571)
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "province参数类型不正确")

    def test_add_address_failed_city_type(self):
        res = Action().type_para("city", 571)
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "city参数类型不正确")

    def test_add_address_failed_area_type(self):
        res = Action().type_para("area", 571)
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "area参数类型不正确")

    def test_add_address_failed_name_lack(self):
        res = Action().lack_para("receiverName")
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "receiverName参数不存在")

    def test_add_address_failed_phone_lack(self):
        res = Action().lack_para("cellPhone")
        self.assertEqual(res['code'], 400)
        # self.assertEqual(res['message'], "cellPhone参数不存在")
        self.assertEqual(res['message'], "may not be null")

    def test_add_address_failed_detail_lack(self):
        res = Action().lack_para("addressDetail")
        self.assertEqual(res['code'], 400)
        # self.assertEqual(res['message'], "addressDetail参数不存在")
        self.assertEqual(res['message'], "may not be null")

    def test_add_address_failed_province_lack(self):
        res = Action().lack_para("province")
        self.assertEqual(res['code'], 400)
        # self.assertEqual(res['message'], "province参数不存在")
        self.assertEqual(res['message'], "may not be null")

    def test_add_address_failed_city_lack(self):
        res = Action().lack_para("city")
        self.assertEqual(res['code'], 400)
        # self.assertEqual(res['message'], "city参数不存在")
        self.assertEqual(res['message'], "may not be null")

    def test_add_address_failed_area_lack(self):
        res = Action().lack_para("area")
        self.assertEqual(res['code'], 400)
        # self.assertEqual(res['message'], "area参数不存在")
        self.assertEqual(res['message'], "may not be null")

    def test_add_address_success_provincecity(self):
        res = Action().para("张三", "12345678901", "复旦大学", "上海市", "上海市", "黄埔区")
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "成功")

    def test_add_address_failed_area_mismatch(self):
        res = Action().error_para("area")
        self.assertEqual(res['code'],400)
        self.assertEqual(res['message'], "请求参数不正确")

    def test_add_address_failed_city_mismatch(self):
        res = Action().error_para("city")
        self.assertEqual(res['code'],400)
        self.assertEqual(res['message'], "请求参数不正确")

    def test_add_address_failed_cityAndarea_mismatch(self):
        res = Action().error_para("city", "area")
        self.assertEqual(res['code'],400)
        self.assertEqual(res['message'], "请求参数不正确")

    def test_add_address_failed_cityAndareaAndprovince_mismatch(self):
        res = Action().error_para("city", "area", "province")
        self.assertEqual(res['code'],400)
        self.assertEqual(res['message'], "请求参数不正确")

    def test_add_address_failed_same_address(self):
        res = Action().default_para()
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "收货地址已存在")

    def test_add_address_failed_exce(self):
        res = Action().exce_address()
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "最多只能添加6个地址")

    def test_add_address_failed_logout(self):
        res = Action().logout_add()
        self.assertEqual(res['code'], 400)
        self.assertEqual(res['message'], "未登录")


if __name__ == '__main__':
    unittest.main()

