class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeKListsRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsRange(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsRange(lists, start, mid);
        ListNode right = mergeKListsRange(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }
}