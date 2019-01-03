import unittest
import requests
import json
from api2018 import Common
from api2018.Sendhttp import SendHttp


# 岳哲伟 提交订单

class Submit(unittest.TestCase):
    def setUp(self):
        self.url = "/fgadmin/orders/submit"

    def test_submit(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        data = {
            "skuIds": "2,3",
            "skuNumbers": "1,1",
            "stockIds": "74966312,74966313",
            "receiverName": " 张 三",
            "cellPhone": "12615813537",
            "addressDetail": "1 栋 栋 3  单 元",
            "province": " 浙江省",
            "city": " 杭州市",
            "area": " 滨 江 区",
            "voiceStatus": 0,
            "needInvoice": 0,
            "invoiceHead": "",
            "transportFee": 0,
            "logisticsCompanyId": 1,
            "accessSource": "noSource"
        }
        result = SendHttp().send_post_bycookie(self.url,Common.getcookies(user), data)
        print(result)
        self.assertEqual(result['code'], 200)
    def test_submit1(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        data = {
            "skuIds": "2,3", "skuNumbers": "1,1", "stockIds": "74966312,74966313", "receiverName": "张三",
            "cellPhone": "12615813537", "addressDetail": "1 栋 3 单元", "province": "浙江省", "city": "杭州市",
            "area": "滨江区", "voiceStatus": 0, "needInvoice": 0, "invoiceHead": "", "transportFee": 0,
            "logisticsCompanyId": 1, "accessSource": "noSource", "accessDevice": 0
        }
        result = SendHttp().send_post_bycookie(self.url,Common.getcookies(user), data)
        print(result)
        self.assertEqual(result['code'], 200)
    def test_submit2(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000001", "password": "netease123"}
        data = {
            "skuIds": "2,3",
            "skuNumbers": 11,
            "stockIds": "74966312,74966313",
            "receiverName": "张三",
            "cellPhone": "12615813537",
            "addressDetail": "1 栋 3 单元",
            "province": "浙江省",
            "city": "杭州市",
            "area": "滨江区",
            "voiceStatus": 0,
            "needInvoice": 0,
            "invoiceHead": "",
            "transportFee": 0,
            "logisticsCompanyId": 1,
            "accessSource": "noSource",
            "accessDevice": 0
        }
        # result = SendHttp().send_post_bycookies(self.url, Common.getcookies(user), data)
        result = SendHttp().send_post_bycookie(self.url,Common.getcookies(user), data)
        print(result)
        self.assertEqual(result['code'], 200)


    def test_submit14(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        data = {
            "skuIds": "222222,3333333", "skuNumbers": "1,1", "stockIds": "74966312,74966313",
            "receiverName": "张三", "cellPhone": "12615813537", "addressDetail": "1 栋 3 单元",
            "province": "浙江省", "city": "杭州市", "area": "滨江区", "voiceStatus": 1, "needInvoice": 1,
            "invoiceHead": "网易杭州研究院", "transportFee": 0, "logisticsCompanyId": 1,
            "accessSource": "noSource", "accessDevice": 0}
        result = SendHttp().send_post_bycookie(self.url,Common.getcookies(user), data)
        print(result)
        self.assertEqual(result['code'], 200)
    if __name__=='__main__':
        unittest.main()
