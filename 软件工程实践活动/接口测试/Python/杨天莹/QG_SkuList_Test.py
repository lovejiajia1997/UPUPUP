import unittest
from api2018 import Common
from api2018.Sendhttp import SendHttp

#获取商品列表  杨天莹
#get  不需要登录
class getskuList(unittest.TestCase):
    def setUp(self):
        self.url="/common/skuList"

    #获取全部商品列表
    def test_getAll_skuList(self):
         result=SendHttp().sent_get(self.url,'GET')
         print(result)
         self.assertEqual(200,result['code'])

    #获取goodsId为1的商品
    def test_getskuListBygoodsId(self):
        paramdata={"goodsId":"1"}
        result = SendHttp().run_http(self.url,'GET',paramdata)
        print(result)
        self.assertEqual(200,result['code'])

    #获取超过最大取值范围的goodsID
    def test_getskuListBygoodsId_fullNum(self):
        paramdata = {"goodsId": "2147483648"}
        result = SendHttp().run_http(self.url, 'GET',paramdata)
        print(result)
        self.assertEqual( 200,result['code'],'超过最大取值范围的goodsID')

    #获取goodsID不存在的商品
    def test_getskuListBygoodsId_noneNum(self):
        paramdata = {"goodsId": "9999"}
        result = SendHttp().run_http(self.url, 'GET',paramdata)
        print(result)
        self.assertEqual(201,result['code'],'goodsID不存在')

    #获取goodsID 类型不正确的商品
    def test_getskuListBygoodsId_wrong(self):
        paramdata = {"goodsId": "'1'"}
        result = SendHttp().run_http(self.url,'GET', paramdata )
        print(result)
        self.assertEqual(result['code'], 400,'商品ID参数类型不正确')


    if __name__ == '__main__':
        unittest.main()




