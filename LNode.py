class LNode:
    def __init__(self, elem, next_=None):
        self.elem = elem
        self.next = next_


class Llist:
    def __init__(self):
        self._head = None

    def prepend(self, elem):  # 表头插入
        self._head = LNode(elem, self._head)

    def printall(self):  # 打印链表
        p = self._head
        while p:
            print(p.elem, end='')
            if p.next:
                print(',', end='')
            p = p.next
            print('')

    def append(self, elem):
        if self._head is None:
            self._head = LNode(elem)
            return
        p = self._head
        while p.next:
            p = p.next
        p.next = LNode(elem)

    def insert(self, elem, n):  # 在第n个位置插入
        p = self._head
        a = 0
        while p is not None:
            p = p.next
            a += 1
        if n < 0 or n == 0:
            print("无效数字")
        elif n == 1:
            self.prepend(elem)
        elif n > a or n == a:
            self.append(elem)
        else:
            q = self._head
            for i in range(1, n - 1):
                q = q.next
            q.next = LNode(elem, q.next)

    def pop(self):  # 弹出表头
        if self._head == None:
            print("链表为空")
        else:
            e = self._head.elem
            self._head = self._head.next
            return e

    def poplast(self):  # 弹出表尾
        p = self._head
        if p == None:
            print("链表为空")
        elif p.next == None:
            self.pop()
        elif p.next.next == None:
            e = p.next.elem
            p.next = None
            return e
        else:
            while p.next.next:
                p = p.next
            e = p.next.elem
            p.next = None
            return e

    def search(self, n):  # 查找第n的位置的元素
        p = self._head
        if p == None:
            a = 0
        else:
            a = 0
            while p.next:
                p = p.next
                a += 1
            a = a + 1
        if n < 0 or n == 0:
            print("无效数字")
        elif n > a:
            print("下标溢出")
        else:
            q = self._head
            for i in range(n - 1):
                q = q.next
            return q.elem

    def change(self, n, ele):  # 更改第n个节点
        p = self._head
        a = 0
        while p is not None:
            p = p.next
            a += 1
        if n < 0 or n == 0:
            print("无效数字")
        elif n > a:
            print("下标溢出")
        else:
            q = self._head
            for i in range(n - 1):
                q = q.next
            q.elem = ele
