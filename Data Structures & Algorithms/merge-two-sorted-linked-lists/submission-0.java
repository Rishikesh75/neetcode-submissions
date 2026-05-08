class Solution {

    public ListNode addNode(ListNode tail,int val){
        ListNode node = new ListNode(val);

        tail.next = node;
        return tail.next;
    }   

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while(list1!= null || list2!= null){

            if(list1!= null && list2 !=null){

                if(list1.val <= list2.val)
                {
                    ans = addNode(ans,list1.val);
                    list1 = list1.next;
                }

                else{
                    ans = addNode(ans,list2.val);
                    list2 = list2.next;
                }
            }

            else if(list1 == null){

                while(list2!=null){
                    ans = addNode(ans,list2.val);
                    list2 = list2.next;
                }
            }

            else if(list2 == null){

                while(list1!=null){
                    ans = addNode(ans,list1.val);
                    list1 = list1.next;
                }
            }
        }

        return dummy.next;
    }
}