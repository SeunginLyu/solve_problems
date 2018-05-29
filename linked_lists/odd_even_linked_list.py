# Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
#
# You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
#
# Example:
#
# Input: 1->2->3->4->5->NULL
# Output: 1->3->5->2->4->NULL
# Note:
#
# The relative order inside both the even and odd groups should remain as it was in the input.
# The first node is considered odd, the second node even and so on ...

class Solution:
    def oddEvenList(self, head):
        new_head = ListNode(0)
        new_head.next = head
        curr = new_head.next
        if(curr and curr.next):
            even_start = curr.next
        else:
            return new_head.next
        while(curr):
            if(curr.next and curr.next.next):
                nextNode = curr.next.next
                curr.next.next = nextNode.next
                curr.next = nextNode
                curr = curr.next
            else:
                curr.next = even_start
                curr = even_start
                break;
        while(curr):
            print(curr.val)
            if(curr.next):
                nextNode = curr.next
                curr.next = nextNode
                curr = curr.next
            else:
                return new_head.next
    // elegant solution
    def oddEvenList(self, head):
        odds = ListNode(0)
        evens = ListNode(0)
        oddsHead = odds
        evensHead = evens
        isOdd = True
        while head:
            if isOdd:
                odds.next = head
                odds = odds.next
            else:
                evens.next = head
                evens = evens.next
            isOdd = not isOdd
            head = head.next
        evens.next = None
        odds.next = evensHead.next
        return oddsHead.next
