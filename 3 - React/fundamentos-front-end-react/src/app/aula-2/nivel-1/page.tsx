import { Contador } from "@/components/Contador";
import Link from "next/link";

const Page = () => (
    <div>
      <h1 className="text-4xl font-bold"> Página do nível 1</h1>
      <Contador />
    </div>
);

export default Page;