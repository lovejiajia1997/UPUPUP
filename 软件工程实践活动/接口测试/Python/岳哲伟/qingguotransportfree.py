import unittest
from api2018 import Common
from api2018.Sendhttp import SendHttp
#岳哲伟计算运费
class getFee(unittest.TestCase):
    def setUp(self):
        self.url ="/common/getTransportFee"

    def test_get_fee(self):
        paradata = {"id":1,"addressDetail":"浙江省_杭州市_滨江区"}
        result = SendHttp().sent_get(self.url, paradata)
        print(result)
    def test_get_fee1(self):
        paradata = {"id":1.25,"addressDetail":"浙江省_杭州市_滨江区"}
        result = SendHttp().sent_get(self.url, paradata)
        print(result)

    def test_get_fee2(self):
        paradata = {"id":"" , "addressDetail": "浙江省_杭州市_滨江区"}
        result = SendHttp().sent_get(self.url, paradata)
        print(result)

    def test_get_fee3(self):
        paradata = {"id": 1, "addressDetail": "123"}
        result = SendHttp().sent_get(self.url, paradata)
        print(result)

    def test_get_fee4(self):
        paradata = {"id": 1, "addressDetail": ""}
        result = SendHttp().sent_get(self.url, paradata)
        print(result)

    def test_get_fee5(self):
        paradata = {"id": 2, "addressDetail": "浙江省_杭州市_滨江区"}
        result = SendHttp().sent_get(self.url, paradata)
        print(result)
# if '__name__'=="__main__":
#     getFee.test_get_fee()