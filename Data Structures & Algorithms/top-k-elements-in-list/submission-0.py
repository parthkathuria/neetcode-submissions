class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # frequency array solution
        freq_map = defaultdict(int)
        for num in nums:
            freq_map[num] += 1
        
        freq_arr = [[count, num] for num, count in freq_map.items()]
        freq_arr.sort()

        res = []
        while len(res) < k:
            res.append(freq_arr.pop()[1])
        
        return res
        