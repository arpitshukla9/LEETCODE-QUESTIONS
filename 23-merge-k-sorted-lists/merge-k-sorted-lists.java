class Solution {
    ListNode MergeTwoList(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val <= list2.val) {
            list1.next = MergeTwoList(list1.next, list2);
            return list1;
        } else {
            list2.next = MergeTwoList(list1, list2.next);
            return list2;
        }
    }

    ListNode PartitionAndMerge(int start, int end, ListNode[] list){
        if(start > end) return null;
        if(start == end) return list[start];
        int mid = start + (end - start) / 2;
        ListNode list1 = PartitionAndMerge(start, mid , list);
        ListNode list2 = PartitionAndMerge(mid+1, end,  list);

        return MergeTwoList(list1, list2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        return PartitionAndMerge(0, lists.length - 1, lists);
    }
}