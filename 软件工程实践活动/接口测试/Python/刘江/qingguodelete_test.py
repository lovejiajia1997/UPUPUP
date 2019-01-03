import unittest
from api2018.Sendhttp import SendHttp


class qgDeletTest(unittest.TestCase):
    def setUp(self):
        self.url = "/fgadmin/address/delete"
    def test_delete_by_deleteId_success(self):
        deleteId = 82181628
        result = SendHttp().run_http(self.url, "POST", deleteId)
        print(result)
        self.assertEqual(['code'],200)
        self.assertEqual(result['message'], 'success')
    def test_delete_by_deleteId_fail(self):
        deleteId = 821
        result = SendHttp().run_http(self.url, "POST", deleteId)
        print(result)
        self.assertEqual(['code'], 201)
        self.assertEqual(result['message'], 'fail')