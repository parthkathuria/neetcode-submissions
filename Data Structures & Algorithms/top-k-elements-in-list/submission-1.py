from _heapq import heapify
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # min heap solution
        freq_map = defaultdict(int)
        for num in nums:
            freq_map[num] += 1
        
        heap = []
        for num, count in freq_map.items():
            heapq.heappush(heap, (count, num))
            if len(heap) > k:
                heapq.heappop(heap)
            
        res = []
        while heap:
            res.append(heapq.heappop(heap)[1])
        
        return res
        