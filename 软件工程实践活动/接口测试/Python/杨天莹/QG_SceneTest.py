import unittest
from api2018.Sendhttp import SendHttp
from api2018 import Common


class SceneTest(unittest.TestCase):
    # 场景法 杨天莹

    def setUp(self):
        self.login_url = "/common/fgadmin/login"
        self.skuList_url = "/common/skuList"
        self.Address_list_url = "/fgadmin/address/list"
        self.Add_address_url = "/fgadmin/address/new"
        self.getFee_url = "/common/getTransportFee"
        self.submit_url = "/fgadmin/orders/submit"
        self.user = {"phoneArea": "86", "phoneNumber": "200000000066", "password": "netease123"}

    # 场景一：浏览商品列表并查看商品详情
    def test_scene1(self):
        # 获取所有商品的sku列表
        result1 = SendHttp().sent_get(self.skuList_url)
        print(result1)
        self.assertEqual(200, result1['code'])

        # 获取goodsId=1的商品sku信息
        result2 = SendHttp().sent_get(self.skuList_url, {"goodsId": "1"})
        print(result2)
        self.assertEqual(200, result2['code'])

        # 获取goodsId=2的商品sku信息
        result3 = SendHttp().sent_get(self.skuList_url, {"goodsId": "2"})
        print(result3)
        self.assertEqual(200, result3['code'])

        # 获取goodsId=3的商品sku信息
        result4 = SendHttp().sent_get(self.skuList_url, {"goodsId": "3"})
        print(result4)
        self.assertEqual(200, result4['code'])
        print('以上为场景一')

    # 场景二：未登录，有收货地址
    def test_scene2(self):
        # 实现登录
        login_result = SendHttp().run_http(self.login_url, "POST", self.user)
        cookies = Common.getcookies(self.user)
        print(cookies)
        print(login_result)

        # 查询收货地址
        address_list_result = SendHttp().sent_get_bycookies(self.Address_list_url, cookies)
        province = address_list_result['result']['list'][0]['province']
        city = address_list_result['result']['list'][0]['city']
        area = address_list_result['result']['list'][0]['area']
        receiverName = address_list_result['result']['list'][0]['receiverName']
        cellPhone = address_list_result['result']['list'][0]['cellPhone']
        addressDetail = address_list_result['result']['list'][0]['addressDetail']
        print(address_list_result)

        # 计算运费
        address = {"addressDetail": "province+'_'+city+'_'+area", "id": "1", "tm": "1542069300054"}
        getFee_result = SendHttp().sent_get_bycookies(self.getFee_url, cookies, address)
        print(getFee_result)
        transportFee = getFee_result['result']
        print(transportFee)

        # 提交订单
        param = {"skuIds": "2,3", "skuNumbers": "1,1", "stockIds": "74966312,74966313",
                 "receiverName": receiverName, "cellPhone": cellPhone, "addressDetail": addressDetail,
                 "province": province, "city": city, "area": area,
                 "transportFee": transportFee, "logisticsCompanyId": 1, }
        submit_result = SendHttp().send_post_bycookie(self.submit_url, cookies, param)
        print(submit_result)

        self.assertEqual(200, submit_result['code'])
        print('以上为场景二')

    # 场景三：已登录、无收货地址
    def test_scene3(self):
        # 查询收货地址
        address_list_result = SendHttp().sent_get_bycookies(self.Address_list_url, Common.getcookies(self.user))
        print(address_list_result)
        self.assertEqual(200, address_list_result['code'])

        # 添加收货地址
        paramdata = {"id": "",
                     "receiverName": "杨天莹2",
                     "cellPhone": "12222222222",
                     "province": "北京市", "city": "朝阳区",
                     "area": "",
                     "addressDetail": "某某小区"
                     }
        Add_address_result = SendHttp().send_post_bycookie(self.Add_address_url, Common.getcookies(self.user),
                                                           paramdata)
        print(Add_address_result)
        self.assertEqual(200, Add_address_result['code'])

        address_list_result = SendHttp().sent_get_bycookies(self.Address_list_url, Common.getcookies(self.user))

        province = address_list_result['result']['list'][0]['province']
        city = address_list_result['result']['list'][0]['city']
        area = address_list_result['result']['list'][0]['area']
        receiverName = address_list_result['result']['list'][0]['receiverName']
        cellPhone = address_list_result['result']['list'][0]['cellPhone']
        addressDetail = address_list_result['result']['list'][0]['addressDetail']

        # 计算运费
        address = {"addressDetail": "province+'_'+city+'_'+area", "id": "1", "tm": "1545210105957"}
        getFee_result = SendHttp().sent_get_bycookies(self.getFee_url, Common.getcookies(self.user), address)
        transportFee = getFee_result['result']
        print(transportFee)

        # 提交订单
        param = {"skuIds": 3,
                 "skuNumbers": 2,
                 "stockIds": 74966313,
                 "receiverName": receiverName,
                 "cellPhone": cellPhone,
                 "addressDetail": addressDetail,
                 "province": province,
                 "city": city,
                 "area": area,
                 "voiceStatus": 0,
                 "needInvoice": 0,
                 "invoiceHead": "",
                 "transportFee": 0,
                 "logisticsCompanyId": 1,
                 "accessSource": "noSource",
                 "accessDevice": 0}

        submit_result = SendHttp().send_post_bycookie(self.submit_url, Common.getcookies(self.user), param)
        print(submit_result)
        print('以上为场景三')

    # 场景四：已登录，有收货地址
    def test_scene4(self):
        # 查询收货地址
        address_list_result = SendHttp().sent_get_bycookies(self.Address_list_url, Common.getcookies(self.user))
        province = address_list_result['result']['list'][0]['province']
        city = address_list_result['result']['list'][0]['city']
        area = address_list_result['result']['list'][0]['area']
        receiverName = address_list_result['result']['list'][0]['receiverName']
        cellPhone = address_list_result['result']['list'][0]['cellPhone']
        addressDetail = address_list_result['result']['list'][0]['addressDetail']
        print(address_list_result)

        # 计算运费
        address = {"addressDetail": "province+'_'+city+'_'+area", "id": "1", "tm": "1542069300054"}
        getFee_result = SendHttp().sent_get_bycookies(self.getFee_url, Common.getcookies(self.user), address)
        print(getFee_result)
        transportFee = getFee_result['result']
        print(transportFee)

        # 提交订单
        param = {"skuIds": "2,3", "skuNumbers": "1,1", "stockIds": "74966312,74966313",
                 "receiverName": receiverName, "cellPhone": cellPhone, "addressDetail": addressDetail,
                 "province": province, "city": city, "area": area,
                 "transportFee": transportFee, "logisticsCompanyId": 1, }
        submit_result = SendHttp().send_post_bycookie(self.submit_url, Common.getcookies(self.user), param)
        print(submit_result)

        self.assertEqual(200, submit_result['code'])
        print('以上为场景四')

    # 场景五：未登录，无收货地址
    def test_scene5(self):
        # 实现登录
        login_result = SendHttp().run_http(self.login_url, "POST", self.user)
        cookies = Common.getcookies(self.user)
        print(cookies)
        print(login_result)

        # 查询收货地址
        address_list_result = SendHttp().sent_get_bycookies(self.Address_list_url, Common.getcookies(self.user))
        print(address_list_result)
        self.assertEqual(200, address_list_result['code'])

        # 添加收货地址
        paramdata = {"id": "",
                     "receiverName": "小红",
                     "cellPhone": "12222222222",
                     "province": "北京市", "city": "朝阳区",
                     "area": "",
                     "addressDetail": "某某小区"
                     }
        Add_address_result = SendHttp().send_post_bycookie(self.Add_address_url, Common.getcookies(self.user),
                                                           paramdata)
        print(Add_address_result)
        self.assertEqual(200, Add_address_result['code'])

        address_list_result = SendHttp().sent_get_bycookies(self.Address_list_url, Common.getcookies(self.user))

        province = address_list_result['result']['list'][0]['province']
        city = address_list_result['result']['list'][0]['city']
        area = address_list_result['result']['list'][0]['area']
        receiverName = address_list_result['result']['list'][0]['receiverName']
        cellPhone = address_list_result['result']['list'][0]['cellPhone']
        addressDetail = address_list_result['result']['list'][0]['addressDetail']

        # 计算运费
        address = {
            "addressDetail": "province+'_'+city+'_'+area",
            "id": "1",
            "tm": "1545210105957"
        }
        getFee_result = SendHttp().sent_get_bycookies(self.getFee_url, Common.getcookies(self.user), address)
        transportFee = getFee_result['result']
        print(transportFee)

        # 提交订单
        param = {"skuIds": 3,
                 "skuNumbers": 2,
                 "stockIds": 74966313,
                 "receiverName": receiverName,
                 "cellPhone": cellPhone,
                 "addressDetail": addressDetail,
                 "province": province,
                 "city": city,
                 "area": area,
                 "voiceStatus": 0,
                 "needInvoice": 0,
                 "invoiceHead": "",
                 "transportFee": 0,
                 "logisticsCompanyId": 1,
                 "accessSource": "noSource",
                 "accessDevice": 0}

        submit_result = SendHttp().send_post_bycookie(self.submit_url, Common.getcookies(self.user), param)
        print(submit_result)
        print('以上为场景五')

if __name__ == '__main__':
    unittest.main()
