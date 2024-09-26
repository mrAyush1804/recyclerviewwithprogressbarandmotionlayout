//package com.example.recyclerviewprectice
//
//class testclass {
//
//    itemTouchHelper.attachToRecyclerView(recyclerView) val itemTouchHelper = ItemTouchHelper(object :
//        ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
//        override fun onMove(
//            recyclerView: RecyclerView,
//            viewHolder: RecyclerView.ViewHolder,
//            target: RecyclerView.ViewHolder
//        ): Boolean {
//            return false
//        }
//
//        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//
//            val position = viewHolder.adapterPosition
//
//
//            if (direction == ItemTouchHelper.LEFT || direction == ItemTouchHelper.RIGHT) {
//                // Remove item from the data list
//                data.removeAt(position)
//
//                adpter.notifyItemRemoved(position)
//            }
//
//        }
//
//    })
//    itemTouchHelper.attachToRecyclerView(recyclerView)
//}
//
